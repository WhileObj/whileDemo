package Producer_consumer_model;

public class BaoZi {
    private String xian;
    private String pi;
    private boolean flag=false;

    public BaoZi() {
    }

    public BaoZi(String xian, String pi) {
        this.xian = xian;
        this.pi = pi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
