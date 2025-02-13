package com.example.todo.service.task;

public record TaskEntity(
        Long id, // セクション9 73. 型をlong→Longに変更。オブジェクトなのでnullを渡せるようになる。
        String summary,
        String description,
        TaskStatus status
) {

}
