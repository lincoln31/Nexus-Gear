// src/pages/ProductListPage.jsx
import ProductCard from '../components/ProductCard';
import { useProducts } from '../hooks/useProducts';

// Datos de prueba mientras no tenemos la API conectada
const mockProducts = [
  { id: 1, name: 'Producto de Prueba 1', description: 'Descripción del producto 1.', price: '29.99', imageUrl: null },
  { id: 2, name: 'Producto de Prueba 2', description: 'Descripción del producto 2.', price: '49.99', imageUrl: null },
];

const pageStyle = {
  display: 'flex',
  flexWrap: 'wrap',
  justifyContent: 'center',
  fontFamily: 'sans-serif'
}
const messageStyle = {
    textAlign: 'center',
    fontSize: '1.5em',
    width: '100%',
    marginTop: '40px', // Un poco de espacio superior
    fontFamily: 'sans-serif'
  };

function ProductListPage() {
    const { products, loading, error } = useProducts();

  if (loading) {
    return <div style={messageStyle}>Cargando productos...</div>;
  }

  if (error) {
    // Ahora el error de CORS será más visible y amigable para el usuario
    return <div style={messageStyle}>Error al cargar los productos: {error}</div>;
  }

  return (
    <div>
      <h1 style={{ textAlign: 'center' }}>Nuestros Productos</h1>
      <div style={pageStyle}>
        {products.map(product => (
          <ProductCard key={product.id} product={product} />
        ))}
      </div>
    </div>
  );
}

export default ProductListPage;