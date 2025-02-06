package repository.interfaces;

import models.RoomCategory;
import java.util.List;

public interface IRoomCategoryRepository {
    boolean addCategory(RoomCategory Category);
    boolean deleteCategory(RoomCategory Category);
    List<RoomCategory> getAllCategories();
}
