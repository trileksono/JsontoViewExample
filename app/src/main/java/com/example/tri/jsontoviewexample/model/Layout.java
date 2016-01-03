package com.example.tri.jsontoviewexample.model;

import java.util.List;

/**
 * Created by tri on 1/2/16.
 */
public class Layout {

    /**
     * type : container
     * nama : root
     * clazz : Vertical
     * child : [{"type":"field","nama":"label","clazz":"textview","field":"Name "},{"type":"field","nama":"xtx","clazz":"edittext","field":""},{"type":"field","nama":"xtxt","clazz":"textview","field":""}]
     */

    private String type;
    private String nama;
    private String clazz;
    /**
     * type : field
     * nama : label
     * clazz : textview
     * field : Name
     */

    private List<ChildEntity> child;

    public void setType(String type) {
        this.type = type;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setChild(List<ChildEntity> child) {
        this.child = child;
    }

    public String getType() {
        return type;
    }

    public String getNama() {
        return nama;
    }

    public String getClazz() {
        return clazz;
    }

    public List<ChildEntity> getChild() {
        return child;
    }

    public static class ChildEntity {
        private String type;
        private String nama;
        private String clazz;
        private String field;

        public void setType(String type) {
            this.type = type;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getType() {
            return type;
        }

        public String getNama() {
            return nama;
        }

        public String getClazz() {
            return clazz;
        }

        public String getField() {
            return field;
        }
    }
}
