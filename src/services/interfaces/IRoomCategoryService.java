package services.interfaces;

import models.RoomCategory;

import java.util.List;

public interface IRoomCategoryService {
    boolean addCategory(RoomCategory category);
    List<RoomCategory> getAllCategories();
}
