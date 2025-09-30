 class LibrarySystem {
    public static void main(String[] args) {
        
        @FunctionalInterface
        interface Book {
            void read(String readerInfo);
        }

        class ConcreteBook implements Book {
            private String title;

            public ConcreteBook(String title) {
                this.title = title;
            }

            @Override
            public void read(String readerInfo) {
                System.out.println("Книга читается: " + title);
                System.out.println("Читатель: " + readerInfo);
            }
        }

        class LibraryCatalog {
            private java.util.Map<String, Book> books = new java.util.HashMap<>();

            public Book getBook(String title) {
                if (!books.containsKey(title)) {
                    books.put(title, new ConcreteBook(title));
                }
                return books.get(title);
            }
        }

        LibraryCatalog catalog = new LibraryCatalog();

        Book book1 = catalog.getBook("Война и мир");
        Book book2 = catalog.getBook("Война и мир");
        Book book3 = catalog.getBook("Преступление и наказание");

        book1.read("Анна И.");
        book2.read("Петр С.");
        book3.read("Мария П.");
    }
}
