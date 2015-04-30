package dk.dm844.webshop

class CategoryService {

    static transactional = false

    List<Category> getCategories() {
        return Category.list([sort: 'name', order: 'asc'])
    }

    List<Product> getProducts(Category c) {
        return Product.findAllByCategory(c, [sort: 'name', order: 'asc'])
    }
}
