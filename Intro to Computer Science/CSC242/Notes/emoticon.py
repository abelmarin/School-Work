import turtle

def drawEye(t,xp,yp):
    t.penup()
    t.goto(xp,yp)
    t.pendown()
    t.dot(25)

def drawSmiley(t,x,y):
    # set turtle direction and pen size
    t.pensize(3)
    t.setheading(0)

    # move to (x, y) and draw head
    t.penup()
    t.goto(x, y)
    t.pendown()
    t.circle(100)

    # draw right eye
    drawEye(t,x+35,y+120)

    # draw left eye
    drawEye(t,x-35,y+120)

    #draw smile
    t.penup()
    t.goto(x-60.62, y+65)
    t.pendown()
    t.setheading(-60)  # smile is a 120 degree
    t.circle(70, 120)  # section of a circle

s = turtle.Screen()
t = turtle.Turtle()

drawSmiley(t,0,0)
drawSmiley(t,70,-70)
drawSmiley(t,140,35)
drawSmiley(t,-140,35)
drawSmiley(t,-70,-70)

