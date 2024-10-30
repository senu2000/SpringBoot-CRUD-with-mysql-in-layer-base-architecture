import React, { useState } from 'react';

const AddProductForm = () => {
    const [formData, setFormData] = useState({
        name: '',
        brand: '',
        quantity: '',
        category: '',
        price: '',
        volume: '',
    });
    const [imageFile, setImageFile] = useState(null);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        setImageFile(file);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        const formDataToSend = new FormData();
        formDataToSend.append('image', imageFile);
        formDataToSend.append('paintDto', JSON.stringify(formData));

        try {
            const response = await fetch('http://localhost:8080/api/paint', {
                method: 'POST',
                body: formDataToSend,
                headers: {
                    'Content-Type': 'multipart/form-data', // Set content type to multipart/form-data
                },
            });
            const data = await response.json();
            console.log(data);
        } catch (error) {
            console.error('Error:', error);
        }

    };


    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="name" placeholder="Name" value={formData.name} onChange={handleInputChange} />
            <input type="text" name="brand" placeholder="Brand" value={formData.brand} onChange={handleInputChange} />
            <input type="text" name="quantity" placeholder="Quantity" value={formData.quantity} onChange={handleInputChange} />
            <input type="text" name="category" placeholder="Category" value={formData.category} onChange={handleInputChange} />
            <input type="text" name="price" placeholder="Price" value={formData.price} onChange={handleInputChange} />
            <input type="text" name="volume" placeholder="Volume" value={formData.volume} onChange={handleInputChange} />
            <input type="file" name="image" accept="image/*" onChange={handleImageChange} />
            <button type="submit">Add Product</button>
        </form>
    );
};

export default AddProductForm;
