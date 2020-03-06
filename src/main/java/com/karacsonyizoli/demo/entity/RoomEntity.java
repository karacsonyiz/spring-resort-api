package com.karacsonyizoli.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "rooms", schema = "demo")
public class RoomEntity {

        @Id
        @GeneratedValue
        private int id;
        private int price;
        private int size;
        private int capacity;
        private boolean breakfast;
        private boolean featured;
        private String name;
        private String slug;
        private String type;
        private String description;
        @Column(name="extras0")
        private String extras;
        @Column(name="fileurl1")
        private String imgUrl;

        public RoomEntity() {
        }

        public RoomEntity(int id, String name, String slug, String type, int price, int size, int capacity, boolean breakfast, boolean featured, String description, String extras, String imgUrl) {
            this.id = id;
            this.name = name;
            this.slug = slug;
            this.type = type;
            this.price = price;
            this.size = size;
            this.capacity = capacity;
            this.breakfast = breakfast;
            this.featured = featured;
            this.description = description;
            this.extras = extras;
            this.imgUrl = imgUrl;
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

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public boolean isBreakfast() {
            return breakfast;
        }

        public void setBreakfast(boolean breakfast) {
            this.breakfast = breakfast;
        }

        public boolean isFeatured() {
            return featured;
        }

        public void setFeatured(boolean featured) {
            this.featured = featured;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getExtras() {
            return extras;
        }

        public void setExtras(String extras) {
            this.extras = extras;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        @Override
        public String toString() {
            return "RoomEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", slug='" + slug + '\'' +
                    ", type='" + type + '\'' +
                    ", price=" + price +
                    ", size=" + size +
                    ", capacity=" + capacity +
                    ", breakfast=" + breakfast +
                    ", featured=" + featured +
                    ", description='" + description + '\'' +
                    ", extras='" + extras + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    '}';
        }

}
