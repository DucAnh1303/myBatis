package mybatis.example.springbootdemomybatis.model;


public class Response {
    private String name;
    private String url;
    private String type;
    private long size;
    private String message;

    public Response(String name, String url, String type, long size, String message) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
        this.message = message;
    }

    public Response(String name, String url, String type, long size) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
