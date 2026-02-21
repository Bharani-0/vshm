export default function DashboardPage() {
  const cards = [
    { title: 'Total Vehicles', value: '12' },
    { title: 'Upcoming Services', value: '4' },
    { title: 'Overdue Services', value: '2' }
  ];

  return (
    <section>
      <h2>Dashboard</h2>
      <div className="cards">
        {cards.map((card) => (
          <article key={card.title} className="card">
            <span>{card.title}</span>
            <strong>{card.value}</strong>
          </article>
        ))}
      </div>
    </section>
  );
}
