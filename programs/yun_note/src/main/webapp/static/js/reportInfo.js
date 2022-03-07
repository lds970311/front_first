console.log("123")

function getData() {
    $.ajax({
        type: 'get',
        url: "ReportServlet",
        data: {
            actionName: "month"
        },
        success: function (result) {
            console.log(result)
            if (result.code == 1) {
                const monthList = result.result.monthList
                const monthData = result.result.monthData
                //加载柱状图
                initChart(monthList, monthData)
            } else {
                alert("报表数据加载失败!")
            }
        },
        error: function (error) {
            console.log(error)
        }
    })
}

getData()

function initChart(monthList, monthData) {
    /*    let monthList = ['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上'];
        let monthData = [22, 18, 11, 23, 20, 33, 31, 23, 44, 32, 9, 49];*/

    let yMax = 50;
    let dataShadow = [];
    for (let i = 0; i < monthData.length; i++) {
        dataShadow.push(yMax);
    }

    const myChart = echarts.init(document.getElementById('monthChart'));

    const option = {
        title: {
            text: '按月统计', // 主标题
            subtext: '通过月份查询对应的云记数量', // 副标题
            left: 'center' // 标题对齐方式，center表示居中
        },
        tooltip: {},
        legend: {
            data: ["月份"]
        },
        xAxis: {
            data: monthList,
            axisLabel: {
                inside: true,
                color: '#fff'
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
            z: 10
        },
        yAxis: {
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                color: '#999'
            }
        },
        dataZoom: [
            {
                type: 'inside'
            }
        ],
        series: [
            {
                type: 'bar',
                showBackground: true,
                itemStyle: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {offset: 0, color: '#83bff6'},
                        {offset: 0.5, color: '#188df0'},
                        {offset: 1, color: '#188df0'}
                    ])
                },
                emphasis: {
                    itemStyle: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                            {offset: 0, color: '#2378f7'},
                            {offset: 0.7, color: '#2378f7'},
                            {offset: 1, color: '#83bff6'}
                        ])
                    }
                },
                data: monthData,
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}


function initMap() {
    $.ajax({
        url: "ReportServlet",
        type: "get",
        data: {
            actionName: "location"
        },
        success: function (result) {
            const map = new BMapGL.Map("baiduMap");
            map.addControl(new BMapGL.ScaleControl())
            map.addControl(new BMapGL.CityListControl())
            map.enableScrollWheelZoom(true);
            result.forEach(item => {
                let point = new BMapGL.Point(item.lon, item.lat);
                let marker = new BMapGL.Marker(point);
                map.addOverlay(marker);
            })
            map.centerAndZoom(new BMapGL.Point(result[0].lon, result[0].lat), 10);
        }
    })
}

initMap()