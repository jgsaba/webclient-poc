package atlantico.poc.contentconsumer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class MirrorPayload {

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created")
    private Date created;

    private String service;

    public MirrorPayload(){}

    public MirrorPayload(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public MirrorPayload(String title, String content, Date created) {
        this.title = title;
        this.content = content;
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
