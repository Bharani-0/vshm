export default function VehiclesPage() {
  return (
    <section>
      <h2>Vehicle Management</h2>
      <table>
        <thead>
          <tr>
            <th>Vehicle Name</th>
            <th>Model</th>
            <th>Registration</th>
            <th>Fuel Type</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Toyota Camry</td>
            <td>2021</td>
            <td>AB-1234</td>
            <td>Petrol</td>
            <td>
              <button>Edit</button>
              <button className="danger">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </section>
  );
}
