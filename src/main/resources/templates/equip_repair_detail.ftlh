<!DOCTYPE html>
<html lang="en">
<head>
    <title>${equipment.name}</title>
    <#include "style.ftlh">

         <style>
                    body{margin:10px;}
                    label{margin-bottom:10px;}
                    .name{margin-left: 138px;}
                    .status{margin-left: 162px;}
                    .location{margin-left:78px}
                    .serialNumber{margin-left:80px}
                    .inventoryNumber{margin-left:55px}
                    .manufacturer{margin-left:94px}
                    .quantity{margin-left:123px}
                    .typesOfWork{margin-left:122px}
                    .pastInventoryDate{}
                    .futureInventoryDate{margin-left:15px}
                    .pastCalibrationDate{margin-left:59px}
                    .futureCalibrationDate{margin-left:74px}
                    .back{margin-top:10px;}
         </style>

</head>
<body>
Оборудование:
${equipment.name}
${equipment.status}
${equipment.location}
${equipment.serialNumber}
${equipment.inventoryNumber}
${equipment.manufacturer}
${equipment.quantity}
${equipment.typesOfWork}
${equipment.pastInventoryDate}
${equipment.futureInventoryDate}
${equipment.pastCalibrationDate}
${equipment.futureCalibrationDate}
<h5>Редактировать данные:</h5>
<form action="/equip_repair/${equipment.id}" method="post">
    <input type="hidden" name="id" value="${equipment.id}">

    <div>
        <label>Название:
            <input class="name" name="name" value="${equipment.name}"<#if role == "[USER]"> type="hidden"</#if> required>
        </label>
    </div>

    <div>
        <label>Статус:
            <input class="status" name="status" value="${equipment.status}" required>
        </label>
    </div>

    <div>
        <label>Местоположение:
            <input class="location" name="location" value="${equipment.location}" required>
        </label>
    </div>

    <div>
        <label>Серийный номер:
            <input class="serialNumber" name="serialNumber" value="${equipment.serialNumber}"<#if role == "[USER]"> type="hidden"</#if>
                   required>
        </label>
    </div>

    <div>
        <label>Инвентарный номер:
            <input class="inventoryNumber" name="inventoryNumber" value="${equipment.inventoryNumber}"<#if role == "[USER]"> type="hidden"</#if>
                   required>
        </label>
    </div>

    <div>
        <label>Производитель:
            <input class="manufacturer" name="manufacturer" value="${equipment.manufacturer}"<#if role == "[USER]"> type="hidden"</#if>
                   required>
        </label>
    </div>

    <div>
        <label>Количество:
            <input class="quantity" name="quantity" value="${equipment.quantity}"<#if role == "[USER]"> type="hidden"</#if> required>
        </label>
    </div>

    <div>
        <label>Виды работ:
            <input class="typesOfWork" name="typesOfWork" value="${equipment.typesOfWork}"<#if role == "[USER]"> type="hidden"</#if>
                   required>
        </label>
    </div>

    <div>
        <label>Дата прош. инвентаризации:
            <input class="pastInventoryDate" name="pastInventoryDate" value="${equipment.pastInventoryDate}" required>
        </label>
    </div>

    <div>
        <label>Дата буд. инвентаризации:
            <input class="futureInventoryDate" name="futureInventoryDate" value="${equipment.futureInventoryDate}" required>
        </label>
    </div>

    <div>
        <label>Дата прош. поверки:
            <input class="pastCalibrationDate" name="pastCalibrationDate" value="${equipment.pastCalibrationDate}" required>
        </label>
    </div>

    <div>
        <label>Дата буд. поверки:
            <input class="futureCalibrationDate" name="futureCalibrationDate" value="${equipment.futureCalibrationDate}" required>
        </label>
    </div>

    <button type="submit">Обновить</button>
</form>

<a href="/equip_repair">
    <button class="back" type="submit">Назад</button>
</a>
</body>
</html>
