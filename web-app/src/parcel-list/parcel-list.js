import { Container } from "@mui/material";
import { useContext } from "react";
import ParcelContext from "../parcels-view/parcels-view"

function ParcelList(props) {
    return (
        <Container>
            <h5>dsds</h5>
            <p>{JSON.stringify(props.parcel)} </p>   
        </Container>
    );  
  }
  
  export default ParcelList;