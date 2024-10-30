import React, {useEffect} from 'react';
import axios from "axios";

function SearchResults(props) {

    useEffect(() => {
        const fetchCartItems = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/cart/1');
                console.log(response.data);
            } catch (error) {
                console.error('Error fetching Users:', error);
            }
        };

        fetchCartItems();
    }, []);

    return (
        <div>Search result page</div>
    );
}

export default SearchResults;