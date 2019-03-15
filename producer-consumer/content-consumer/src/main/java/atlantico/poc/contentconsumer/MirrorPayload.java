package atlantico.poc.contentconsumer;

import java.util.Date;

public class MirrorPayload {

    private String title;
    private String content;
    private Date created;
    private String service;

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
