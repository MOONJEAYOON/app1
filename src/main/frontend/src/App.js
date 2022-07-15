import React, { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import Main from './components/Main';
import LoginPage from './components/LoginPage';
import Register from './components/Register';
import Calculator from './components/Calculator';
import History from './components/History';
import Modal from './components/Modal';

const App = () => {
    const [modalOpen, setModalOpen] = useState(false);

    const openModal = () => {
        setModalOpen(true);
    };
    const closeModal = () => {
        setModalOpen(false);
    };
    return (
        <>
            <BrowserRouter>
                <Header />
                <Routes>
                    <Route path="/" element={<Main />}></Route>
                    <Route path="/sign_in" element={<LoginPage />}></Route>
                    <Route path="/sign_up" element={<Register />}></Route>
                    <Route path="/Calculator" element={<Calculator />}></Route>
                    <Route path="/history" element={<History />}></Route>

                </Routes>
            </BrowserRouter>
            <button onClick={openModal}>게시판 모달팝업</button>
            <Modal open={modalOpen} close={closeModal} header="Modal heading">
            </Modal>
        </>
    );
};

export default App;