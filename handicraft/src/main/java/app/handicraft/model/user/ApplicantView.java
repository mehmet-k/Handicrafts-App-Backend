package app.handicraft.model.user;

import app.handicraft.model.course.CourseView;

import java.util.List;

public record ApplicantView(
        UserView userView,
        List<CourseView> courseViewList
) {
}
