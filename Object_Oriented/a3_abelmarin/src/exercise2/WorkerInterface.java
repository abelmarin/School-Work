// Abel Marin
// Exercise 2
package exercise2;

interface WorkerInterface {
    public void work();
}

interface HumanWorkerInterface extends WorkerInterface {
    public void eat();
}

class Worker implements HumanWorkerInterface {
    public void work() {}
    public void eat() {}
}

class SuperWorker implements HumanWorkerInterface {
    public void work() {}
    public void eat() {}
}

class Robot implements WorkerInterface {
    public void work() {}
}

class Manager {
    WorkerInterface worker;
    public void setWorker(WorkerInterface w) {
        worker=w;
    }
    public void manage() {
        worker.work();
    }
}