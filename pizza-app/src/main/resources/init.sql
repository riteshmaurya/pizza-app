    drop table AUTO_USER if exists;
    drop table ORDER_MASTER if exists;
    drop table ORDER_DETAILS if exists;
    drop table PIZZA if exists;
    
     create table ORDER_MASTER (
        ORDER_ID bigint generated by default as identity (START WITH 1000),
        ORDER_DATE timestamp,
        TOTAL_ITEMS varchar(255),
        STATUS varchar(255),
        USER_ID bigint,
        TOTAL_PRICE varchar(255),
        DELIVERY_ADDRESS varchar(255),
        primary key (ORDER_ID)
    );
        
     create table PIZZA (
        PIZZA_ID bigint generated by default as identity,
        PIZZA_SIZE varchar(255) ,
        PIZZA_BASE varchar(255) ,
        TOPPING_MUSHROOM boolean ,
        TOPPING_CHICKEN boolean ,
        TOPPING_EXTRACHEESE boolean ,
        TOPPING_MEATBALL boolean ,
        UNIT_PRICE varchar(255) ,
        QUANTITY smallint ,
        CREATION_DATE timestamp,
        primary key (PIZZA_ID)
    );    


     create table ORDER_PIZZA (
        ORDER_ID bigint not null,
        PIZZA_ID bigint not null,
        primary key (ORDER_ID, PIZZA_ID)
    );      
    
    
    alter table ORDER_PIZZA 
        add constraint OrderMaster_FK 
        foreign key (ORDER_ID) 
        references ORDER_MASTER;    

    alter table ORDER_PIZZA 
        add constraint PIZZA_FK 
        foreign key (PIZZA_ID) 
        references PIZZA;  
        
    create table AUTO_USER (
        autoUserId bigint generated by default as identity,
        EMAIL varchar(255),
        FIRST_NAME varchar(255),
        LAST_NAME varchar(255),
        PASSWORD varchar(255),
        USERNAME varchar(255),
        ROLE varchar(255),
        DELIVERY_ADDRESS varchar(255),
        primary key (autoUserId)
    );    
        
insert into AUTO_USER (autoUserId, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, ROLE, DELIVERY_ADDRESS) values (null, 'riteshmaurya@gmail.com', 'Ritesh', 'Maurya', 'password', 'rmaurya', 'ROLE_ADMIN', 'plymouth st. 1');
insert into AUTO_USER (autoUserId, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, ROLE, DELIVERY_ADDRESS) values (null, 'riteshmaurya1@gmail.com', 'User1', 'Maurya1', 'password', 'user1', 'ROLE_USER', 'plymouth st. 2');
insert into AUTO_USER (autoUserId, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, ROLE, DELIVERY_ADDRESS) values (null, 'riteshmaurya2@gmail.com', 'User2', 'Maurya2', 'password', 'user2', 'ROLE_USER', 'plymouth st. 3');
insert into AUTO_USER (autoUserId, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, ROLE, DELIVERY_ADDRESS) values (null, 'riteshmaurya3@gmail.com', 'User3', 'Maurya3', 'password', 'user3', 'ROLE_USER', 'plymouth st. 4');

;