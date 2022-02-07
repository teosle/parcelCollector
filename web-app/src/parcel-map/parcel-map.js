import { MapContainer, Marker, Popup, TileLayer, GeoJSON } from 'react-leaflet'
import "leaflet/dist/leaflet.css"
import "./parcel-map.css"
import L from 'leaflet';
import { PinDropSharp, RoomPreferences } from '@mui/icons-material';

delete L.Icon.Default.prototype._getIconUrl;

L.Icon.Default.mergeOptions({
    iconRetinaUrl: require('leaflet/dist/images/marker-icon-2x.png'),
    iconUrl: require('leaflet/dist/images/marker-icon.png'),
    shadowUrl: require('leaflet/dist/images/marker-shadow.png')
});

const position = [54.4, 18.4]

function ParcelMap(props) {

    let geoData ={
        type: "FeatureCollection",
        features: []
    };

    geoData.features = props.parcel.map((tmp) => {
        return {
            type: "Feature",
            geometry: tmp.geom,
            properties: {}
        }});
    console.log(geoData);

    return (
        <MapContainer center={position} zoom={11} scrollWheelZoom={false}>
            <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />
            {props.parcel.length > 0 && props.parcel.map((tmpParcel) => (
                <GeoJSON key={tmpParcel.id} data = {tmpParcel.geom}>
                    <Popup>
                        {tmpParcel.name}
                    </Popup>
                </GeoJSON>
            ))}
            
        </MapContainer>
    );
  }
  
  export default ParcelMap;