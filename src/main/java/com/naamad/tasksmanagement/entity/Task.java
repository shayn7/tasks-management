package com.naamad.tasksmanagement.entity;

import com.naamad.tasksmanagement.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private String title;
    private String description;
    private Status status;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User assignee;

}
