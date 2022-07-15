import { useState, useEffect } from "react";
import axios from 'axios';
import InfoList from "./InfoList";

const History = () => {
    const [blogs, setBlogs] = useState(null);
    const [listCut, setlistCut] = useState(10);

    useEffect(() => {

        axios.get('/api/calculator', {
            params: {
                page: 1,
                size: listCut
            }
        })
            .then(function (response) {
                setBlogs(response.data.data);
                console.log(response.data.data);
                setlistCut(listCut + 5);
            })
            .catch(function (error) {
                console.log(error);
            });
    }, []);


    const moreList = () => {

        axios.get('/api/calculator', {
            params: {
                page: 1,
                size: listCut
            }
        })
            .then(function (response) {
                setBlogs(response.data.data);
                console.log(response.data.data);
                setlistCut(listCut + 5);
            })
            .catch(function (error) {
                console.log(error);
            });

    }

    const removeList = (e) => {
        // const id = e.target.getAttribute('data-name');
        // setDelUrl(id);

        axios.delete(`/api/calculator/${e.target.getAttribute('data-name')}`)
            .then(function (response) {
                console.log("삭제");


            })
            .catch(function (error) {
                // handle error
                //     console.log(error);
            })
            .then(function () {
                axios.get('/api/calculator', {
                    params: {
                        page: 1,
                        size: 10
                    }
                })
                    .then(function (response) {
                        setBlogs(response.data.data);
                        console.log(response.data.data);
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            });
    }

    return (
        <>
            <div onClick={removeList}>
                <h3>결과값들이 리스트로 보여집니다.</h3>
                {blogs && <InfoList blogs={blogs} />}

            </div>

            <button
                type="button" onClick={moreList}
            >
                더보기(+5)
            </button>
        </>
    );
};
export default History;