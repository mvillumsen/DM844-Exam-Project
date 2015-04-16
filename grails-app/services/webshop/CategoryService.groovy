package webshop

import dk.dm844.webshop.Category
import dk.dm844.webshop.Product

class CategoryService {

    static transactional = false

    List<Category> getCategories() {
        return Category.list([sort: 'name', order: 'asc'])
    }
}
