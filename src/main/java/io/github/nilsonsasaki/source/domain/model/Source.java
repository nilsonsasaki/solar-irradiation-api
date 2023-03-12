package io.github.nilsonsasaki.source.domain.model;

import io.github.nilsonsasaki.exception.domain.IllegalNullArgumentException;

public class Source {

    private long id;
    private String externalId;
    private String source;
    private String date;
    private String url;

    public Source(Long id, String externalId, String source, String date, String url) {
        if (id == null) throw new IllegalNullArgumentException("id");
        if (externalId == null) throw new IllegalNullArgumentException("externalId");
        if (date == null) throw new IllegalNullArgumentException("date");
        if (source == null) throw new IllegalNullArgumentException("source");
        this.id = id;
        this.externalId = externalId;
        this.source = source;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", source='" + source + '\'' +
                '}';
    }
}
