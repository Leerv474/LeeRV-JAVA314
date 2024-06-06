-- -- 1. Показать все книги, количество страниц в которых больше 500, но меньше 650.
-- select * from books where pages between 500 and 650;
--
-- -- 2. Показать все книги, в которых первая буква названия либо «А», либо «З».
-- select * from books where substring(name, 1, 1) = 'A' or substring(name, 1, 1) = 'H';
--
-- -- 3. Показать все книги жанра «Детектив», количество проданных книг более 30 экземпляров.
-- select * from books where theme_id = (select id from themes where name = 'Mystery') limit 30;
--
-- -- 4. Показать все книги, в названии которых есть слово "Microsoft", но нет слова "Windows". 
-- select * from books where name like '%Microsoft%' and name not like '%Windows%';
--
-- -- 5. Показать все книги (название, тематика, полное имя автора в одной ячейке), цена одной страницы которых меньше 65 копеек. 
-- select concat_ws(' ', b.name, t.name, a.surname, a.name) as books_info 
-- from books b
-- join themes t on t.id = b.theme_id
-- join authors a on a.id = b.author_id
-- where b.price/ b.pages < 0.65;

-- -- 6. Показать все книги, название которых состоит из 4 слов.
-- select * from books where length(name) - length(replace(name, ' ', '')) + 1  = 4;
--
-- -- 7. Показать информацию о продажах в следующем виде:
-- -- ▷ Название книги, но, чтобы оно не содержало букву «А».
-- -- ▷ Тематика, но, чтобы не «Программирование».
-- -- ▷ Автор, но, чтобы не «Герберт Шилдт».
-- -- ▷ Цена, но, чтобы в диапазоне от 10 до 20 гривен.
-- -- ▷ Количество продаж, но не менее 8 книг.
-- -- ▷ Название магазина, который продал книгу, но он не должен быть в Украине или России
-- select b.name as book, t.name as theme, concat(a.surname, ' ', a.name) as author, b.price, s.quantity as sales, sh.name as shop
-- from books b
-- join themes t on t.id = b.theme_id
-- join authors a on a.id = b.author_id
-- join sales s on s.book_id = b.id
-- join shops sh on sh.id = s.shop_id
-- where b.name not like '%A%'
-- and t.name <> 'Science Fiction'
-- and concat(a.surname, ' ', a.name) <> 'Герберт Шилдт'
-- and b.price between 10 and 20
-- and s.quantity >= 8
-- and sh.country_id not in (select name from countries where id = sh.country_id);
--
-- -- 8. Показать следующую информацию в два столбца (числа в правом столбце приведены в качестве примера):
-- -- ▷ Количество авторов: 14
-- -- ▷ Количество книг: 47
-- -- ▷ Средняя цена продажи: 85.43 грн.
-- -- ▷ Среднее количество страниц: 650.6.
-- select 'number of authors' as info, (select count(*) from authors) as value
-- union all
-- select 'number of books', (select count(*) from books)
-- union all
-- select 'average price', (select avg(price) from books)
-- union all
-- select 'average amount of pages', (select avg(pages) from books);

-- -- 9. Показать тематики книг и сумму страниц всех книг по каждой из них.
-- select name as theme, (select sum(pages) from books where theme_id = id) as pages from themes;

-- -- 10. Показать количество всех книг и сумму страниц этих книг по каждому из авторов.
-- select surname || name as author, (select count(*) from books where author_id = id) as number_of_books, (select sum(pages) from books where author_id = id) as sum_of_pages from authors;

-- -- 11. Показать книгу тематики «Программирование» с наибольшим количеством страниц.
-- select * from books where pages = (select max(pages) from books where theme_id = (select id from themes where name = 'Fantasy')) limit 1;

-- -- 12. Показать среднее количество страниц по каждой тематике, которое не превышает 400. 
-- select t.name, avg_pages
-- from themes t
-- join (select avg(pages) as avg_pages, theme_id from books group by theme_id) a on a.theme_id = t.id
-- where avg_pages <= 400;

-- -- 13. Показать сумму страниц по каждой тематике, учитывая только книги с количеством страниц более 400,
-- -- и чтобы тематики были «Программирование», «Администрирование» и «Дизайн».
-- select sum(b.pages)
-- from books b
-- join themes t on t.id = b.theme_id
-- where pages <= 400 and t.name not in ('Programming', 'Administrating', 'Design');

-- -- 14. Показать информацию о работе магазинов: что, где, кем, когда и в каком количестве было продано.
-- select b.name as book, c.name as country, sh.name as shop, s.sale_date as sale_date, s.quantity
-- from sales s
-- join books b on s.book_id = b.id
-- join shops sh on sh.id = s.shop_id
-- join countries c on c.id = sh.country_id;

-- -- 15. Показать самый прибыльный магазин.
-- select sh.name, i.income  
-- from shops sh
-- join (select sum(price) as income, shop_id from sales group by shop_id) i on sh.id = shop_id 
-- order by income desc limit 1;

