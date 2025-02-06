package controllers;

import models.RoomCategory;
import services.interfaces.IRoomCategoryService;


import java.util.List;

public class RoomCategoryController {
    private final IRoomCategoryService roomCategoryService;

    public RoomCategoryController(IRoomCategoryService roomCategoryService) {
        this.roomCategoryService = roomCategoryService;
    }

    public boolean addCategory(RoomCategory category) {
        return roomCategoryService.addCategory(category);
    }

    public boolean deleteCategory(RoomCategory category) {return roomCategoryService.deleteCategory(category);}

    public List<RoomCategory> getAllCategories() {
        return roomCategoryService.getAllCategories();
    }



}
