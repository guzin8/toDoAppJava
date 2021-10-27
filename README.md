# toDoAppJava

Java Spring Backend/Frontend

Projede 5 katmanlı bir mimari kurulmuştur.
1.	Entity
2.	DataAcess
3.	Core
4.	Business
5.	Api

Entity Katmanı
Burada toDoItem ve User varlıklarımı oluşturdum.
Veritabanı ile bağlantıyı sağlamak için Spring’in @Entity(Veri tabanı nesnesi olduğunu söyler) @Table gibi anotasyonlarını kullandım. Ayrıca lombok’ı entegre ettim. Lombok bir kütüphanedir. @Data(getter ve setter oluşturur), @AllArgsConstoructor(Sınıfın tüm parametrelerini alarak constructor oluşturur) ve @NoArgsConstructor(Parametresiz Constructor üretir) gibi anotasyonlarıyla daha kısa ve temiz kod yazmamızı sağlar. 

DataAccess Katmanı
Burada Spring’in JpaRepository interface’ini extend ederek değerleri de vererek hangi tabloya hangi id veri tipiyle sorguların oluşturulması gerektiğini yazdım. Sorgulara örnek olarak: findAll, findById…

Core Katmanı
Api’ye yaptığım isteklerin doğru ya da yanlış olduğunu göstermek için results oluşturdum. Sonuç ve aynı zamanda veri döndürecek isteklerim için DataResults oluşturdum. Bu katmanda tüm projelerde kullanmak isteyeceğim yapıları oluşturuyorum.

Business Katmanı
Burada abstracts ve concretes olarak tekrar iki paket oluşturdum. Veri tabanına yapacağım işlemleri buraya yazdım. Managerlarda dao’lar oluşturup @Autowired anotasyonuyla initialize işlemini arka planda yapılmasını sağladım ve dependency injection yöntemini kullandım. Dao’ları constructor injection yoluyla manager classlara enjekte ettim. Bunların haricinde Spring’in security’sini kullanarak kayıt olan kullanıcıların login işlemini yaparken doğrulamasını gerçekleştirmek için authenticatedUserDetails ve authenticatedUserDetailsService’leri oluşturdum. Servis kısmında kullanıcının mail adresini vererek mail adresi üzerinden kullanıcının olup olmadığını kontrol ettim.

Api Katmanı 
Bu katmanda controller’larımı oluşturdum. Controller, MVC’de projenin iç süreçlerini kontrol eden bölümdür. Bu bölümde View ile Model arasındaki bağlantı kurulur. Kullanıcılardan gelen istekler (request) Controller’larda değerlendirilir, isteğin detayına göre hangi işlemlerin yapılacağı ve kullanıcıya hangi View’ın döneceği (response) belirtilir. User ve ToDoItem Controller’larımı oluşturdum ve business katmanıyla bağlantıyı interfaceler aracılığıyla sağladım. Get, post ve put methodlarımı yazdım. Bunların haricinde appController’da templates klasöründe oluşturduğum html dosyalarını döndürdüğüm methodları yazdım. 

Veritabanı
Veritabanı bağlantısını application.properties dosyasında yaptım. “spring.jpa.hibernate.ddl.auto” özelliğini ilk başta “create” yaparak tablolarımı veritabanında otomatik olarak oluşturmasını sağladım. Sonrasında ise bu özelliği “none” yaparak verilerin kalmasını ve programı her çalıştırdığımda tabloları sıfırdan oluşturmasını engelledim.

JUnit Test
“src/test/java” klasöründe ToDoItem ve User için test classları oluşturdum. ToDoItem’da itemin oluşturulmasını test ettim. User’da ise hem user oluşturma hem de mail adresine göre Veritabanında kullanıcı olup olmadığını kontrol eden testi yazdım.

Projeyi çalıştırma
Projeyi çalıştırıp http://localhost:8080/swagger-ui.html#/ bu adrese gittiğimde controllerlarımı ve get-post işlemlerimi gördüm. GetAll ve findByEmail methodlarımı burada çalıştırabiliyorum ancak login işleminin doğrulanması olayından dolayı post işlemleri 403 http hatası veriyor. Ancak http://localhost:8080/ sayfasına(ana sayfa) gidip register ve login işlemlerini gerçekleştirdiğimde itemları listeleyen sayfaya; http://localhost:8080/addItem adresine gittiğimde ise itemları ekleyip veritabanına kaydettiğimi gördüm. Delete ve update işlemlerini front-end kısmında gerçekleştiremedim. 
