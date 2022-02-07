import { Container } from "@mui/material";
import { DataGrid } from '@mui/x-data-grid';

const columns = [
    { field: 'name', headerName: 'Name', width: 100 },
    { field: 'area', headerName: 'Area', width: 80, type: 'number', valueFormatter: ({  value }) => `${Math.round(value)} m2` },
  ];
  

function ParcelList(props) {
    return (
        <div style={{ height: "85vh", width: '100%' }}>
            <DataGrid rows={props.parcel} columns={columns} />  
        </div>
    );  
  }
  
  export default ParcelList;