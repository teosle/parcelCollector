import './App.css';
import ParcelsView from './parcels-view/parcels-view';
import AddParcel from './add/add';
import Error from './error/error';
import {
  BrowserRouter,
  Routes,
  Route,
  Link as RouterLink
} from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import { Button } from '@mui/material';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Box sx={{ flexGrow: 1 }}>
          <AppBar position="static">
            <Toolbar>
              <Button
                  sx={{ my: 2, color: 'white', display: 'block' }}
                  component={RouterLink} to="/"
              >
                 Map
              </Button>
              <Button
                sx={{ my: 2, color: 'white', display: 'block' }}
                component={RouterLink} to="/add"
              >
                Add
              </Button>
            </Toolbar>
          </AppBar>
        </Box>
        <Routes>
          <Route path="/" element={<ParcelsView />} />
          <Route path="/add" element={<AddParcel />} />
          <Route path="/*" element={<Error />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
