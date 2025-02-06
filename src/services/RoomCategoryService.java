package services;

import models.RoomCategory;
import repository.interfaces.IRoomCategoryRepository;
import services.interfaces.IRoomCategoryService;

import java.util.List;

public class RoomCategoryService implements IRoomCategoryService {
    private final IRoomCategoryRepository categoryRepository;

    public RoomCategoryService(IRoomCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean addCategory(RoomCategory category) {
        return categoryRepository.addCategory(category);
    }

    @Override
    public boolean deleteCategory(RoomCategory category) {
        return categoryRepository.deleteCategory(category);
    }

    @Override
    public List<RoomCategory> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

}
