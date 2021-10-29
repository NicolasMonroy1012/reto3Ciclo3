function data_user(){
    $.get("/user", function (data) {
        $("#user").html(data.name);
        //console.log(data.name);
    });
    $.get("/photo", function (data_photo) {
        $("#photo").attr("src",data_photo.foto_id);
    });
}
function mostrarNav(){
    $(".cool-link").show();
}
function guardarInfoSkate() {
    let myData = {
        id: $("#id").val(),
        brand: $("#brand").val(),
        model: $("#model").val(),
        category_id: $("#category_id").val(),
        name: $("#name").val()
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Skate/save",
        type: "POST",
        data: myData,
        datatype: "JSON",
        success: function(respuesta) {
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            traerInfoSkate();
            alert("La informacion se ha guardado con exito!")
        }
    });
}

function traerInfoSkate() {
    $("#table_model").empty();
    $.ajax({
        url: "http://localhost:8080/api/Skate/all/",
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            console.log(respuesta.items);
            items = respuesta.items;
            table_model.items = '';
            console.log(items.length)
            for (i = 0; i < items.length; i++) {
                console.log("Ingreso bucle Skate");
                table_model.innerHTML +=
                    `
                        <tr>
                            <td> ${items[i].id}</td>
                            <td> ${items[i].brand}</td>
                            <td> ${items[i].model}</td>
                            <td> ${items[i].category_id}</td>
                            <td> ${items[i].name}</td>
                            <td><button type='button' class='btModel' onclick='edicionSkate(${items[i].id})'><span class='button__icon'><ion-icon name='create-outline'></ion-icon></span></button></td>
                            <td><button type='button' class='btModel' onclick=borrarInfoSkate(${items[i].id})> <span class='button__icon'><ion-icon name='trash-outline'></ion-icon></span></button></td>
                        </tr>
                    `
            }
            $("#resultado").append(tabla_model);
        }
    })

}

function editarInfoSkate() {
    let myData = {
        id: $("#id").val(),
        brand: $("#brand").val(),
        model: $("#model").val(),
        category_id: $("#category_id").val(),
        name: $("#name").val(),
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Skate/update",
        type: "PUT",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function(respuesta) {
            $("#id").val("");
            $("#brand").val("");
            $("model").val("");
            $("#category_id").val("");
            $("#name").val("");
            traerInfoSkate();
            alert("Se ha actualizado la información de manera exitosa")
        }
    });
}

function edicionSkate(idE) {
    var id = idE
    $.ajax({
        url: "http://localhost:8080/api/Skate/"+idE,
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            console.log(respuesta.items);
            items = respuesta.items;
            console.log(items.length)
            for (i = 0; i < items.length; i++) {
                if (items[i].id == id) {
                    console.log("encontré el cliente");
                    $("#id").val(items[i].id);
                    $("#brand").val(items[i].brand);
                    $("#model").val(items[i].model);
                    $("#category_id").val(items[i].category_id);
                    $("#name").val(items[i].name);
                }
            }

        }

    });
}

function borrarInfoSkate(idE) {
    let myData = {
        id: idE
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Skate/"+idE,
        type: "DELETE",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function(respuesta) {
            $("#resultado").empty();
            traerInfoSkate();
            alert("Se ha eliminado la Patineta de manera exitosa");
        }
    });
}
//-----------------------------------------------Cliente--------------------------------------------------------------
function guardarInfoCliente() {
    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val()
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Client/save",
        type: "POST",
        data: myData,
        datatype: "JSON",
        success: function(respuesta) {
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            traerInfoCliente();
            alert("La informacion se ha guardado con exito!")
        }
    });
}

function traerInfoCliente() {
    $("#table_model").empty();
    $.ajax({
        url: "http://localhost:8080/api/Client/all/",
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            console.log(respuesta.items);
            items = respuesta.items;
            table_model.items = '';
            console.log(items.length)
            for (i = 0; i < items.length; i++) {
                console.log("Ingreso bucle Cliente");
                table_model.innerHTML +=
                    `
                        <tr>
                            <td> ${items[i].id}</td>
                            <td> ${items[i].name}</td>
                            <td> ${items[i].email}</td>
                            <td> ${items[i].age}</td>
                            <td><button type='button' class='btModel' onclick='edicionCliente(${items[i].id})'><span class='button__icon'><ion-icon name='create-outline'></ion-icon></span></button></td>
                            <td><button type='button' class='btModel' onclick=borrarInfoCliente(${items[i].id})> <span class='button__icon'><ion-icon name='trash-outline'></ion-icon></span></button></td>
                        </tr>
                    `
            }
            $("#resultado").append(tabla_model);
        }
    })

}

function editarInfoCliente() {
    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val()
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Client/update",
        type: "PUT",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function(respuesta) {
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("age").val("");
            traerInfoCliente();
            alert("Se ha actualizado la información de manera exitosa")
        }
    });
}

function edicionCliente(idE) {
    var id = idE
    $.ajax({
        url: "http://localhost:8080/api/Client/"+idE,
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            console.log(respuesta.items);
            items = respuesta.items;
            console.log(items.length)
            for (i = 0; i < items.length; i++) {
                if (items[i].id == id) {
                    console.log("encontré el cliente");
                    $("#id").val(items[i].id);
                    $("#name").val(items[i].name);
                    $("#email").val(items[i].email);
                    $("#age").val(items[i].age);
                }
            }

        }

    });
}

function borrarInfoCliente(idE) {
    let myData = {
        id: idE
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Client/"+idE,
        type: "DELETE",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function(respuesta) {
            $("#resultado").empty();
            traerInfoCliente();
            alert("Se ha eliminado la Patineta de manera exitosa");
        }
    });
}
//-----------------------------------------------Categoria--------------------------------------------------------------
function guardarInfoMessage() {
    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val()
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Message/save",
        type: "POST",
        data: myData,
        datatype: "JSON",
        success: function(respuesta) {
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            traerInfoCliente();
            alert("La informacion se ha guardado con exito!")
        }
    });
}

function traerInfoMessage() {
    $("#table_model").empty();
    $.ajax({
        url: "http://localhost:8080/api/Message/all/",
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            console.log(respuesta.items);
            items = respuesta.items;
            table_model.items = '';
            console.log(items.length)
            for (i = 0; i < items.length; i++) {
                console.log("Ingreso bucle Message");
                table_model.innerHTML +=
                    `
                        <tr>
                            <td> ${items[i].id}</td>
                            <td> ${items[i].name}</td>
                            <td> ${items[i].email}</td>
                            <td> ${items[i].age}</td>
                            <td><button type='button' class='btModel' onclick='edicionCliente(${items[i].id})'><span class='button__icon'><ion-icon name='create-outline'></ion-icon></span></button></td>
                            <td><button type='button' class='btModel' onclick=borrarInfoCliente(${items[i].id})> <span class='button__icon'><ion-icon name='trash-outline'></ion-icon></span></button></td>
                        </tr>
                    `
            }
            $("#resultado").append(tabla_model);
        }
    })

}

function editarInfoMessage() {
    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val()
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Message/update",
        type: "PUT",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function(respuesta) {
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("age").val("");
            traerInfoCliente();
            alert("Se ha actualizado la información de manera exitosa")
        }
    });
}

function edicionMessage(idE) {
    var id = idE
    $.ajax({
        url: "http://localhost:8080/api/Message/"+idE,
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            console.log(respuesta.items);
            items = respuesta.items;
            console.log(items.length)
            for (i = 0; i < items.length; i++) {
                if (items[i].id == id) {
                    console.log("encontré el cliente");
                    $("#id").val(items[i].id);
                    $("#name").val(items[i].name);
                    $("#email").val(items[i].email);
                    $("#age").val(items[i].age);
                }
            }

        }

    });
}

function borrarInfoMessage(idE) {
    let myData = {
        id: idE
    };
    let dataToSend = JSON.stringify(myData);
    $.ajax({
        url: "http://localhost:8080/api/Message/"+idE,
        type: "DELETE",
        data: dataToSend,
        contentType: "application/JSON",
        datatype: "JSON",
        success: function(respuesta) {
            $("#resultado").empty();
            traerInfoCliente();
            alert("Se ha eliminado la Patineta de manera exitosa");
        }
    });
}