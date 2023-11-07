package ru.zakharov.domain;

public record Filter(int pageNo, int pageSize, String sortField, String sortDirection) {
}
