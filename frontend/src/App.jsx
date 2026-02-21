import { NavLink, Route, Routes } from 'react-router-dom';
import DashboardPage from './pages/DashboardPage';
import VehiclesPage from './pages/VehiclesPage';
import ServicesPage from './pages/ServicesPage';

export default function App() {
  return (
    <div className="layout">
      <aside className="sidebar">
        <h1>VSHM</h1>
        <NavLink to="/">Dashboard</NavLink>
        <NavLink to="/vehicles">Vehicles</NavLink>
        <NavLink to="/services">Services</NavLink>
      </aside>
      <main className="content">
        <Routes>
          <Route path="/" element={<DashboardPage />} />
          <Route path="/vehicles" element={<VehiclesPage />} />
          <Route path="/services" element={<ServicesPage />} />
        </Routes>
      </main>
    </div>
  );
}
