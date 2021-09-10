import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/Sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {
    const [activePage, setActivePage] = useState<number>(0);
    const [page, setPage] = useState<SalePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        numberOfElements: 0,
        first: true,
        size: 0,
        number: 0,
        empty: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=${activePage}&size=20&sort=date,desc`)
            .then(response => {
                setPage(response.data);
                console.log(response.data);
            }).catch(error => {

            });
    }, [activePage]);

    const changePage = (current: number) => {
        setActivePage(current);
    }

    return (
        <>
            <Pagination page={page} onPageChange={changePage} />
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Vendedor</th>
                            <th>Clientes visitados</th>
                            <th>Negócios fechados</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            page.content?.map(item => (
                                <tr key={item.id}>
                                    <td>{formatLocalDate(item.date, 'dd/MM/yyyy')}</td>
                                    <td>{item.seller.name}</td>
                                    <td>{item.visited}</td>
                                    <td>{item.deals}</td>
                                    <td>{item.amount.toFixed(2)}</td>
                                </tr>
                            ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default DataTable;

function setState<T>(arg0: { content: never[]; last: boolean; totalPages: number; totalElements: number; numberOfElements: number; first: boolean; size: number; number: number; empty: boolean; }): [any, any] {
    throw new Error("Function not implemented.");
}
