package observer;

public class softwareObserver implements Observer {
    //订阅者名字
    private String name;
    //订阅的版本
    private int version;

    softwareObserver(String name) {
        this.name = name;
    }

    public void update(int version) {
        this.version = version;
        System.out.println(name + "收到了消息：" + "软件版本更新为：" + version);
        this.buy();
    }

    private void buy() {
        System.out.println(name + "购买了版本号" + version + "的软件");
    }

}


