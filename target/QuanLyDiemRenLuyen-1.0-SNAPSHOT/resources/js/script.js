function deleteHoatDong(url) {
    fetch(url, {method: 'delete'}).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("ERROR");
    })
}

function drawChartTheoKhoa(ctx, labels, data,title) {
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: title ,
                    data: data,
                    borderWidth: 1,
                    backgroundColor:['red', 'green', 'blue', 'gold', 'brown', 'orange']
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

