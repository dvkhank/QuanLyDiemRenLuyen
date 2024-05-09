function deleteHoatDong (url) {
    fetch(url, {method : 'delete'}).then(res => {
        if(res.status ===204)
            location.reload();
        else 
            alert("ERROR");
    })
}
