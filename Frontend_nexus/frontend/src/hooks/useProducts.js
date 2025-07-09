// src/hooks/useProducts.js
import { useState, useEffect } from 'react';

// La URL de nuestra API de backend.
// En un proyecto real, esto estaría en una variable de entorno.
const API_URL = 'http://localhost:8081/api/products';

export function useProducts() {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Definimos una función async dentro del useEffect para poder usar await.
    const fetchProducts = async () => {
      try {
        const response = await fetch(API_URL);
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        setProducts(data);
      } catch (e) {
        setError(e.message);
      } finally {
        setLoading(false);
      }
    };

    fetchProducts();
  }, []); // El array vacío asegura que este efecto se ejecute solo una vez, al montar el componente.

  return { products, loading, error };
}