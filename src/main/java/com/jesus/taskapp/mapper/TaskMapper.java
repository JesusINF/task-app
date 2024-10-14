package com.jesus.taskapp.mapper;

import com.jesus.taskapp.model.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select("SELECT id, name, description, start_date AS startDate FROM tasks")
    List<Task> getAllTasks();

    @Select("SELECT id, name, description, start_date AS startDate FROM tasks WHERE id = #{id}")
    Task getTaskById(int id);

    @Insert("INSERT INTO tasks (name, description, start_date) VALUES (#{name}, #{description}, #{startDate})")
    void insertTask(Task task);

    @Update("UPDATE tasks SET name = #{name}, description = #{description}, start_date = #{startDate} WHERE id = #{id}")
    void updateTask(Task task);

    @Delete("DELETE FROM tasks WHERE id = #{id}")
    void deleteTask(int id);
}
