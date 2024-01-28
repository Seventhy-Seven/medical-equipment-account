<!DOCTYPE html>
<html lang="en">
<head>
    <title>Оборудование</title>
    <#include "style.ftlh">

     <style>
            body {
                   background-color: lightblue;

            }
            h1{text-align: center;}
            form{margin-bottom: 10px;
                 margin-left: 10px;}
            .back{margin-left: 10px;}
        </style>
</head>


<body>
<h1>Перечень медицинского оборудования</h1>
<form action="/equip" method="post">
    <input type="text" name="keyword" placeholder="Введите запрос"/>
    <button type="submit">Найти</button>
</form>
<div class="table-responsive">
    <table class="table table-hover">
        <tr>
            <th>Название</th>
            <th>Статус</th>
            <th>Местоположение</th>
            <th>Серийный номер</th>
            <th>Инвентарный номер</th>
            <th>Производитель</th>
            <th>Количество</th>
            <th>Виды работ</th>
            <th>Действия</th>
        </tr>
        <#list equipmentList as equipment>
            <tr>
                <td>${equipment.name}</td>
                <td>${equipment.status}</td>
                <td>${equipment.location}</td>
                <td>${equipment.serialNumber}</td>
                <td>${equipment.inventoryNumber}</td>
                <td>${equipment.manufacturer}</td>
                <td>${equipment.quantity}</td>
                <td>${equipment.typesOfWork}</td>
                <td>
                    <form action="/equip/${equipment.id}" method="get">
                        <button>Инфо</button>
                    </form>
                    <form action="/equip/delete" method="post">
                        <input type="hidden" name="id" value="${equipment.id}">
                        <button type="submit">Удалить</button>
                    </form>

                </td>
            </tr>
        </#list>
    </table>

    <a href="/index">
        <button class="back" type="submit">Назад</button>
    </a>
</div>
</body>
</html>
