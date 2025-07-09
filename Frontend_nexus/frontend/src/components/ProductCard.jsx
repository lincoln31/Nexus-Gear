// src/components/ProductCard.jsx

// Vamos a añadir un poco de estilo inline para que no se vea tan mal.
// Más adelante integraremos una librería como Tailwind CSS.
const cardStyle = {
    border: '1px solid #ddd',
    borderRadius: '8px',
    padding: '16px',
    margin: '16px',
    width: '300px',
    boxShadow: '0 4px 8px rgba(0,0,0,0.1)',
    fontFamily: 'sans-serif'
  };
  
  const imageStyle = {
    width: '100%',
    height: '200px',
    objectFit: 'cover',
    borderRadius: '4px'
  };
  
  const priceStyle = {
    fontSize: '1.2em',
    fontWeight: 'bold',
    color: '#2c3e50'
  }
  
  // El componente recibe un objeto 'product' como prop.
  function ProductCard({ product }) {
    return (
      <div style={cardStyle}>
        <img src={product.imageUrl || 'https://via.placeholder.com/300x200'} alt={product.name} style={imageStyle} />
        <h3>{product.name}</h3>
        <p>{product.description}</p>
        <p style={priceStyle}>${product.price}</p>
      </div>
    );
  }
  
  export default ProductCard;