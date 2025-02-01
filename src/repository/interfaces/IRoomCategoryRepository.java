package repository.interfaces;

import models.RoomCategory;
import java.util.List;

public interface IRoomCategoryRepository {
    boolean addCategory(RoomCategory Category);
    List<RoomCategory> getAllCategories();
}
