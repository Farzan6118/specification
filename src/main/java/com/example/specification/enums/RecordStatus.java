package com.example.specification.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RecordStatus {
    CREATED,
    UPDATED,
    DISABLED,
    DELETED,
}
