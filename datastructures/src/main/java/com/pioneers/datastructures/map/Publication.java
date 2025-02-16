package com.pioneers.datastructures.map;

import java.util.Objects;

public class Publication {
    private String title;
    private String author;
    private String indexation;

    public Publication(String title, String author, String indexation) {
        this.title = title;
        this.author = author;
        this.indexation = indexation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIndexation() {
        return indexation;
    }

    public void setIndexation(String indexation) {
        this.indexation = indexation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(indexation, that.indexation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, indexation);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", indexation='" + indexation + '\'' +
                '}';
    }
}
