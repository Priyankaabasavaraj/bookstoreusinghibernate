package com.springboot.model;

import java.awt.PageAttributes.MediaType;
import java.awt.print.Pageable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@JsonPropertyOrder({ "page", "size", "totalElements", "totalPages", "last", "content" })
public class  Pagination<T> {
    
    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public Pagination() {

    }

    public Pagination(List<T> content, int page, int size, long totalElements, int totalPages, boolean last) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Pagination<Book> getHoliday(
            @RequestParam(value = "holidayId", required =false) Integer holidayId,
            @RequestParam(value = "holidayName", required = false) String holidayName,
            @RequestParam(value = "date", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date holidayDate,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "size", defaultValue = "0", required = false) int size,
            @RequestParam(value = "sort", defaultValue = "createdDate", required = false) String sort,
            @RequestParam(value = "order", defaultValue = "desc", required = false) String order,
            @And({ 
                @Spec(path = "holidayId", params = "holidayId", spec = Equal.class),
                @Spec(path = "holidayName", params = "holidayName", spec = Equal.class),
                @Spec(path = "holidayDate", params = "holidayDate", spec = Equal.class)}) 
            Specification<Book> spec) {

        Pageable pageable = (size != 0
                ? Pagination.of(page - 1, size,order.trim().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,sort)
                : Pageable.unpaged());
        return service.findAllBooks(pageable, spec);
    }
}
