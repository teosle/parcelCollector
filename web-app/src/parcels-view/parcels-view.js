import { Grid, Typography } from '@mui/material'
import ParcelList from '../parcel-list/parcel-list';
import ParcelMap from '../parcel-map/parcel-map';
import {createContext, useState, useEffect} from "react"

export const ParcelContext = createContext()

function ParcelsView() {
  const [parcel, setParcel] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/parcel/', { })
        .then(res => {
          console.log(res);
          return res.json();
        })
        .then((data) => {
          console.log(data);
          setParcel(data);
        })
        .catch(console.log)
  }, []);

  return (
    <ParcelContext.Provider value={parcel}>
      <Grid container >
          <Grid item xs={2}>
            <Typography variant="h4" component="h4">
              map test
            </Typography>
            <ParcelList parcel = {parcel}/>
          </Grid>
          <Grid item xs={10}>
            <ParcelMap parcel = {parcel}/>
          </Grid>
      </Grid>
    </ParcelContext.Provider>
  );
}

export default ParcelsView;