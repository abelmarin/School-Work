import sys, socket, os
import threading
import socket
 
class Send (threading.Thread):
    def __init__(self, sock, message):
        threading.Thread.__init__(self)
        self.sock = sock
        self.message = message
        
    def run(self):
        while self.message:
            self.sock.send(self.message.encode())
            self.message = sys.stdin.readline().replace("\n", "")
        os._exit(0)
 
class Receive (threading.Thread):
    def __init__(self, sock):
        threading.Thread.__init__(self)
        self.sock = sock
        
    def run(self):
        msg_bytes = self.sock.recv(1024)
        while True:
            print (msg_bytes.decode())
            msg_bytes = self.sock.recv(1024)
        os._exit(0)
 
def usage (script_name):
    print('Usage: py ' + script_name + ' (-l) <port number>')
 
# Server
def server (port):
    serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    serversocket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    serversocket.bind(('', port))
    serversocket.listen(5)
    sock, addr = serversocket.accept()
    serversocket.close()
    receive = Receive(sock)
    receive.start()
    message = sys.stdin.readline().replace("\n", "")
    send = Send(sock, message)
    send.start()
 
# Client
def client (port):
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.connect(('localhost', port))
    receive = Receive(sock)
    receive.start()
    message = sys.stdin.readline().replace("\n", "")
    send = Send(sock, message)
    send.start()
 
args = sys.argv
numArgs = len(args)
if numArgs == 2:
    isServer = False
    portNum = int(args[1])
elif numArgs == 3:
    isServer = True
    portNum = int(args[2])
else:
    usage(args[0])
    sys.exit()
 
if (isServer):
    server(portNum)
else:
    client(portNum)
 