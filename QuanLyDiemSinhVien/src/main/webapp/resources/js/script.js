
function deleteMonhoc(url, id) {
    fetch(url, {
        method: 'delete'

    }).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("ERROR");
    });
    //alert(id);

}

function deleteUser(url, id) {
    fetch(url, {
        method: 'delete'

    }).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("ERROR");
    });
    //alert(id);

}