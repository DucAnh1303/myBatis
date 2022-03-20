package mybatis.example.springbootdemomybatis.model;



import org.apache.ibatis.annotations.Mapper;


import javax.persistence.Lob;
import javax.persistence.Table;


@Table(name = "file")
public class File {
    private int id;
    private String name;
    private String type;
    @Lob
    private byte[] data;

    public File(int id, String name, String type, byte[] data) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public File() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
