import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/Sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
};

const DonutChart = () => {

    //Forma errada
    let chartData: ChartData = {
        labels: [],
        series: []
    };

    /*const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }*/
    
    const options = {
        legend: {
            show: true
        }
    }

    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(d => d.sellerName);
            const mySeries = data.map(d => d.sum);

            chartData = {
                labels: myLabels,
                series: mySeries
            };

            console.log(chartData);
            console.log(data);
        }).catch(error => {

        });
    
    return (
        <Chart options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240" />
    );
}

export default DonutChart;